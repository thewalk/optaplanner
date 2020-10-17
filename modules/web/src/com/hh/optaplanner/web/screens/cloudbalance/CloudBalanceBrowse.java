package com.hh.optaplanner.web.screens.cloudbalance;

import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.screen.*;
import com.hh.optaplanner.entity.CloudBalance;
import com.hh.optaplanner.service.ResolveService;

import javax.inject.Inject;

@UiController("optaplanner_CloudBalance.browse")
@UiDescriptor("cloud-balance-browse.xml")
@LookupComponent("cloudBalancesTable")
@LoadDataBeforeShow
public class CloudBalanceBrowse extends StandardLookup<CloudBalance> {
    @Inject
    private GroupTable<CloudBalance> cloudBalancesTable;

    @Inject
    private ResolveService resolveService;

    @Subscribe("resolveBtn")
    private void onResolveBtnClick(Button.ClickEvent event) {
        CloudBalance cloudBalance = cloudBalancesTable.getSingleSelected();
        resolveService.resolve(cloudBalance.getId());
    }

}