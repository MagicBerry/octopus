package com.octopus.kettlex.core.steps;

import com.octopus.kettlex.core.exception.KettleXStepExecuteException;
import com.octopus.kettlex.model.WriterConfig;

public interface Writer<CONFIG extends WriterConfig<?>> extends Step<CONFIG> {

  void writer() throws KettleXStepExecuteException;
}
