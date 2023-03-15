package com.shawn.octopus.spark.operators.report.metrics;

import com.shawn.octopus.spark.operators.common.declare.transform.metrics.BuiltinMetricsOpType;
import com.shawn.octopus.spark.operators.common.declare.transform.metrics.BuiltinMetricsTransformDeclare;
import com.shawn.octopus.spark.operators.report.metrics.op.Op;
import com.shawn.octopus.spark.operators.report.registry.OpRegistry;
import java.util.List;
import java.util.Map;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class BuiltinMetrics implements Metrics<BuiltinMetricsTransformDeclare> {

  private final BuiltinMetricsTransformDeclare declare;
  private final List<String> columns;

  public BuiltinMetrics(BuiltinMetricsTransformDeclare declare) {
    this.declare = declare;
    this.columns = declare.getOptions().getColumns();
  }

  @Override
  public Object calculate(SparkSession spark, Map<String, Dataset<Row>> dfs) throws Exception {
    BuiltinMetricsOpType opType = declare.getOptions().getOpType();
    Op<?> op = OpRegistry.OP_REGISTRY.get(opType);
    return op.process(spark, dfs, columns);
  }

  @Override
  public BuiltinMetricsTransformDeclare getDeclare() {
    return declare;
  }
}