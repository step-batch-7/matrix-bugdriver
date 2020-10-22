package com.step.math;

public class Matrix {
  int[][] values;
  int noOfRows;
  int noOfColumns;

  public Matrix(int[][] values, int noOfRows, int noOfColumns) {
    this.noOfRows = noOfRows;
    this.noOfColumns = noOfColumns;
    this.values = values;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[ \n");
    for (int[] rows : this.values) {
      sb.append("  [ ");
      for (int cell : rows) {
        sb.append(cell + ", ");
      }
      sb.append("], \n");
    }
    sb.append("]");
    return sb.toString();
  }

  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof Matrix)) {
      return false;
    }
    Matrix otherMatrix = (Matrix) other;
    if (!this.isDimensionEqual(otherMatrix)) {
      return false;
    }
    for (int rowNo = 0; rowNo < this.noOfRows; rowNo++) {
      for (int colNo = 0; colNo < this.noOfColumns; colNo++) {
        if (this.values[rowNo][colNo] != otherMatrix.values[rowNo][colNo]) {
          return false;
        }
      }
    }
    return true;
  }

  private boolean isDimensionEqual(Matrix other) {
    return (
      (this.noOfRows == other.noOfRows) &&
      (this.noOfColumns == other.noOfColumns)
    );
  }

  public Matrix add(Matrix other) {
    if (!this.isDimensionEqual(other)) return null;
    int[][] result = new int[this.noOfRows][this.noOfColumns];
    for (int rowNo = 0; rowNo < this.noOfRows; rowNo++) {
      for (int colNo = 0; colNo < this.noOfColumns; colNo++) {
        result[rowNo][colNo] =
          this.values[rowNo][colNo] + other.values[rowNo][colNo];
      }
    }
    return new Matrix(result, this.noOfRows, this.noOfColumns);
  }

  public Matrix subtract(Matrix other) {
    if (!this.isDimensionEqual(other)) return null;
    int[][] result = new int[this.noOfRows][this.noOfColumns];
    for (int rowNo = 0; rowNo < this.noOfRows; rowNo++) {
      for (int colNo = 0; colNo < this.noOfColumns; colNo++) {
        result[rowNo][colNo] =
          this.values[rowNo][colNo] - other.values[rowNo][colNo];
      }
    }
    return new Matrix(result, this.noOfRows, this.noOfColumns);
  }

  public Matrix multiply(Matrix other) {
    if (this.noOfRows != other.noOfColumns) return null;
    int[][] result = new int[this.noOfRows][other.noOfColumns];

    for (int i = 0; i < this.noOfRows; i++) {
      for (int j = 0; j < other.noOfColumns; j++) {
        for (int k = 0; k < this.noOfColumns; k++) {
          result[i][j] += this.values[i][k] * other.values[k][j];
        }
      }
    }
    return new Matrix(result, this.noOfRows, other.noOfColumns);
  }

  public Matrix createSubMatrix(Matrix matrix, int bisectorRowNo) {
    int[][] temp = new int[matrix.noOfRows - 1][matrix.noOfColumns - 1];

    for (int rowNo = 1; rowNo < matrix.noOfRows; rowNo++) {
      for (int colNo = 0; colNo < matrix.noOfColumns; colNo++) {
        if (colNo < bisectorRowNo) {
          temp[rowNo - 1][colNo] = matrix.values[rowNo][colNo];
        }
        if (colNo > bisectorRowNo) {
          temp[rowNo - 1][colNo - 1] = matrix.values[rowNo][colNo];
        }
      }
    }
    return new Matrix(temp, matrix.noOfRows - 1, matrix.noOfColumns - 1);
  }

  public int determinant() {
    if (this.noOfRows == 1) {
      return this.values[0][0];
    }

    if (this.noOfRows == 2) {
      return (
        (this.values[0][0] * this.values[1][1]) -
        (this.values[0][1] * this.values[1][0])
      );
    }

    int result = 0;

    for (int i = 0; i < this.noOfColumns; i++) {
      Matrix temp = createSubMatrix(this, i);
      result += this.values[0][i] * Math.pow(-1, i) * temp.determinant();
    }
    return result;
  }
}
