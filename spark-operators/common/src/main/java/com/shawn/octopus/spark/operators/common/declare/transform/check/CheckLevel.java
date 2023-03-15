package com.shawn.octopus.spark.operators.common.declare.transform.check;

public enum CheckLevel {
  warning(1),
  critical(2);

  private final int level;

  CheckLevel(int level) {
    this.level = level;
  }

  public int getLevel() {
    return level;
  }
}
