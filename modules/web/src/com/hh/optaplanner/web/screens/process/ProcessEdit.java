package com.hh.optaplanner.web.screens.process;

import com.haulmont.cuba.gui.screen.*;
import com.hh.optaplanner.entity.Process;

@UiController("optaplanner_Process.edit")
@UiDescriptor("process-edit.xml")
@EditedEntityContainer("processDc")
@LoadDataBeforeShow
public class ProcessEdit extends StandardEditor<Process> {
}