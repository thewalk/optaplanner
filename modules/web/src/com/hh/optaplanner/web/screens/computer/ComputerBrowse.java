package com.hh.optaplanner.web.screens.computer;

import com.haulmont.cuba.gui.screen.*;
import com.hh.optaplanner.entity.Computer;

@UiController("optaplanner_Computer.browse")
@UiDescriptor("computer-browse.xml")
@LookupComponent("computersTable")
@LoadDataBeforeShow
public class ComputerBrowse extends StandardLookup<Computer> {
}