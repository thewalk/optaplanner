package com.hh.optaplanner.web.screens.cloudbalance;

import com.haulmont.cuba.gui.screen.*;
import com.hh.optaplanner.entity.CloudBalance;

@UiController("optaplanner_CloudBalance.edit")
@UiDescriptor("cloud-balance-edit.xml")
@EditedEntityContainer("cloudBalanceDc")
@LoadDataBeforeShow
public class CloudBalanceEdit extends StandardEditor<CloudBalance> {
}