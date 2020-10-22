package com.step.math;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MatrixTest {
  private Matrix matrix1;
  private Matrix matrix2;

  private void initMatrices(int[][] matrix1, int[][] matrix2) {
    this.matrix1 = new Matrix(matrix1, 3, 3);
    this.matrix2 = new Matrix(matrix2, 3, 3);
  }

  @Before
  public void initMatrices() {
    int[][] m1 = { { 1, 1, 1 }, { 2, 2, 2 }, { 3, 3, 3 } };
    int[][] m2 = { { 1, 1, 1 }, { 2, 2, 2 }, { 3, 3, 3 } };
    this.initMatrices(m1, m2);
  }

  @Test
  public void shouldAddTwoMatrices() {
    int[][] expected = { { 2, 2, 2 }, { 4, 4, 4 }, { 6, 6, 6 } };
    Matrix expectedMatrix = new Matrix(expected, 3, 3);
    Matrix actual = this.matrix1.add(this.matrix2);
    assertEquals("should add two Matrices", expectedMatrix, actual);
  }

  @Test
  public void shouldSubtractTwoMatrices() {
    int[][] expected = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
    Matrix expectedMatrix = new Matrix(expected, 3, 3);
    Matrix actual = this.matrix1.subtract(this.matrix2);
    assertEquals("should subtract two Matrices", expectedMatrix, actual);
  }

  @Test
  public void shouldMultiplyTwoMatrices() {
    int[][] expected = { { 6, 6, 6 }, { 12, 12, 12 }, { 18, 18, 18 } };
    Matrix expectedMatrix = new Matrix(expected, 3, 3);
    Matrix actual = this.matrix1.multiply(this.matrix2);
    assertEquals("should multiply two Matrices", expectedMatrix, actual);
  }

  @Test
  public void shouldGiveDeterminantOfMatrix() {
    int actual = this.matrix1.determinant();
    assertEquals("should give determinant of Matrix", 0, actual);
  }
}
