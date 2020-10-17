package com.hh.optaplanner.web.screens.computer;

import com.haulmont.cuba.gui.screen.*;
import com.hh.optaplanner.entity.Computer;

@UiController("optaplanner_Computer.edit")
@UiDescriptor("computer-edit.xml")
@EditedEntityContainer("computerDc")
@LoadDataBeforeShow
public class ComputerEdit extends StandardEditor<Computer> {
}