package com.hh.optaplanner.service;

import com.haulmont.cuba.core.global.CommitContext;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.EntitySet;
import com.haulmont.cuba.core.sys.AppContext;
import com.haulmont.cuba.core.sys.SecurityContext;
import com.hh.optaplanner.entity.CloudBalance;
import com.hh.optaplanner.entity.Process;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service(ResolveService.NAME)
public class ResolveServiceBean implements ResolveService {

    @Inject
    private DataManager dataManager;

    @Inject
    private Logger log;

//    @Inject
//    ExecutorService executorService;

    @Override
    public void resolve(UUID uuid) {
        final SecurityContext securityContext = AppContext.getSecurityContext();

        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        singleThreadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                AppContext.setSecurityContext(securityContext);
                SolverFactory<CloudBalance> solverFactory = SolverFactory.createFromXmlResource(
                        "com/hh/optaplanner/solverConfig/cloudBalancingSolverConfig.xml" , this.getClass().getClassLoader());
                Solver<CloudBalance> solver = solverFactory.buildSolver();

                CloudBalance problem = dataManager.load(CloudBalance.class).id(uuid).view("cloudBalance-with-computer-with-process-view").one();
                CloudBalance solution = solver.solve(problem);

                CommitContext cc = new CommitContext();
                cc.addInstanceToCommit(solution);
                for (Process process : solution.getProcessList()) {
                    cc.addInstanceToCommit(process);
                }
                EntitySet entities = dataManager.commit(cc);

                return;
            }
        });
        return;
    }

}