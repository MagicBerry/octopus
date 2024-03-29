package com.octopus.kettlex.core.steps;

import com.octopus.kettlex.core.exception.KettleXStepExecuteException;
import com.octopus.kettlex.model.ReaderConfig;

public interface Reader<CONFIG extends ReaderConfig<?>> extends Step<CONFIG> {

  void read() throws KettleXStepExecuteException;
}
