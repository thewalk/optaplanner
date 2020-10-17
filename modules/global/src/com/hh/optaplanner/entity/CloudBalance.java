package com.hh.optaplanner.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

import javax.persistence.*;
import java.util.List;

@NamePattern("%s|name")
@Table(name = "OPTAPLANNER_CLOUD_BALANCE")
@Entity(name = "optaplanner_CloudBalance")
@PlanningSolution
public class CloudBalance extends StandardEntity {
    private static final long serialVersionUID = 8369037028709538584L;

    @Column(name = "NAME")
    protected String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cloudBalance")
    protected List<Computer> computerList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cloudBalance")
    protected List<Process> processList;

    @Column(name = "HARD_SCORE")
    protected Integer hardScore;

    @Column(name = "SOFT_SCORE")
    protected Integer softScore;

    @Transient
    protected HardSoftScore score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ValueRangeProvider(id = "computerRange")
    @ProblemFactCollectionProperty
    public List<Computer> getComputerList() {
        return computerList;
    }

    public void setComputerList(List<Computer> computerList) {
        this.computerList = computerList;
    }

    @PlanningEntityCollectionProperty
    public List<Process> getProcessList() {
        return processList;
    }

    public void setProcessList(List<Process> processList) {
        this.processList = processList;
    }

    public Integer getHardScore() {
        return hardScore;
    }

    public void setHardScore(Integer hardScore) {
        this.hardScore = hardScore;
    }

    public Integer getSoftScore() {
        return softScore;
    }

    public void setSoftScore(Integer softScore) {
        this.softScore = softScore;
    }

    @PlanningScore
    public HardSoftScore getScore() {
        return HardSoftScore.of(this.hardScore, this.softScore);
    }

    public void setScore(HardSoftScore score) {
        this.score = score;
        this.hardScore = score.getHardScore();
        this.softScore = score.getSoftScore();
    }
}