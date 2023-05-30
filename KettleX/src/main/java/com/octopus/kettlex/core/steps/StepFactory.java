package com.octopus.kettlex.core.steps;

import com.octopus.kettlex.core.exception.KettleXException;
import com.octopus.kettlex.model.StepConfig;
import com.octopus.kettlex.model.reader.RowGeneratorConfig;
import com.octopus.kettlex.model.transformation.ValueMapperConfig;
import com.octopus.kettlex.model.writer.LogMessageConfig;
import com.octopus.kettlex.runtime.reader.RowGenerator;
import com.octopus.kettlex.runtime.transformation.ValueMapper;
import com.octopus.kettlex.runtime.writer.LogMessage;

public class StepFactory {

  public static Step<?> createStep(StepConfig<?> stepMeta) {
    StepType stepType = stepMeta.getType();
    Step<?> step = null;
    switch (stepType) {
      case ROW_GENERATOR:
        step = new RowGenerator((RowGeneratorConfig) stepMeta);
        break;
      case VALUE_MAPPER:
        step = new ValueMapper((ValueMapperConfig) stepMeta);
        break;
      case LOG_MESSAGE:
        step = new LogMessage((LogMessageConfig) stepMeta);
        break;
      default:
        throw new KettleXException("unsupported step type: " + stepType);
    }
    return step;
  }
}