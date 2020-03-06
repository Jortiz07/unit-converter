package edu.cnm.deepdive.unitconverter;

public enum Unit {
  INCH,
  CENTIMETER,
  FOOT,
  YARD,
  METER,
  MILE,
  KILOMETER;

  public static Unit fromString(String text) {
    if (text != null) {
      for (Unit unit : Unit.values()) {
        if (text.equalsIgnoreCase(unit.toString())) {
          return unit;
        }
      }
    }
    throw new IllegalArgumentException("Cannot find a value for" + text);
  }
}
