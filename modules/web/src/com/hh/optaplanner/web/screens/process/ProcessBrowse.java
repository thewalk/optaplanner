package com.hh.optaplanner.web.screens.process;

import com.haulmont.cuba.gui.screen.*;
import com.hh.optaplanner.entity.Process;

@UiController("optaplanner_Process.browse")
@UiDescriptor("process-browse.xml")
@LookupComponent("processesTable")
@LoadDataBeforeShow
public class ProcessBrowse extends StandardLookup<Process> {
}