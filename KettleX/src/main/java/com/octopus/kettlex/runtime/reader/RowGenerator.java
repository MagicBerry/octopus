package com.octopus.kettlex.runtime.reader;

import com.octopus.kettlex.core.exception.KettleXStepExecuteException;
import com.octopus.kettlex.core.row.Record;
import com.octopus.kettlex.core.row.column.Column;
import com.octopus.kettlex.core.row.record.DefaultRecord;
import com.octopus.kettlex.core.steps.BaseStep;
import com.octopus.kettlex.core.steps.Reader;
import com.octopus.kettlex.model.Field;
import com.octopus.kettlex.model.reader.RowGeneratorConfig;
import com.octopus.kettlex.runtime.TaskCombination;
import lombok.Getter;

@Getter
public class RowGenerator extends BaseStep<RowGeneratorConfig>
    implements Reader<RowGeneratorConfig> {

  private final RowGeneratorConfig stepConfig;

  public RowGenerator(RowGeneratorConfig stepConfig, TaskCombination taskCombination) {
    super(stepConfig, taskCombination);
    this.stepConfig = stepConfig;
  }

  @Override
  public void read() throws KettleXStepExecuteException {
    Field[] fields = stepConfig.getOptions().getFields();
    Record record = new DefaultRecord();
    for (Field field : fields) {
      record.addColumn(
          Column.builder()
              .name(field.getName())
              .type(field.getFieldType())
              .rawData(field.getValue())
              .build());
    }
    putRow(record);
  }
}
