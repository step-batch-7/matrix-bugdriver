package com.step.math;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class MatrixTest {
  private Matrix matrix1;
  private Matrix matrix2;

  private void initMatrices(int[][] matrix1, int[][] matrix2) {
    this.matrix1 = new Matrix(matrix1, 3, 3);
    this.matrix2 = new Matrix(matrix2, 3, 3);
  }

  private Matrix matrix_2x2(int a, int b, int c, int d) {
    return new Matrix(new int[][] { { a, b }, { c, d } }, 2, 2);
  }

  @Before
  public void initMatrices() {
    int[][] m1 = { { 1, 1, 1 }, { 2, 2, 2 }, { 3, 3, 3 } };
    int[][] m2 = { { 1, 1, 1 }, { 2, 2, 2 }, { 3, 3, 3 } };
    this.initMatrices(m1, m2);
  }

  @Test
  public void addShouldAddTwo2x2Matrices() {
    Matrix firstMatrix = matrix_2x2(2, 5, 6, 7);
    Matrix secondMatrix = matrix_2x2(4, 3, 5, 2);
    Matrix expectedMatrix = matrix_2x2(6, 8, 11, 9);
    Matrix actual = firstMatrix.add(secondMatrix);
    assertEquals(expectedMatrix, actual);
  }

  @Test
  public void shouldCheckIfDimensionIsNotEqual() {
    Matrix firstMatrix = matrix_2x2(2, 5, 6, 7);
    int[][] m3 = { { 2, 2 }, { 4, 4 }, { 6, 6 } };
    Matrix secondMatrix = new Matrix(m3, 3, 2);
    Matrix actual = firstMatrix.add(secondMatrix);
    assertEquals(null, actual);
  }

  @Test
  public void shouldSubtractTwoMatrices() {
    int[][] expected = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
    Matrix expectedMatrix = new Matrix(expected, 3, 3);
    Matrix actual = this.matrix1.subtract(this.matrix2);
    assertEquals(expectedMatrix, actual);
  }

  @Test
  public void shouldMultiplyTwoMatrices() {
    int[][] expected = { { 6, 6, 6 }, { 12, 12, 12 }, { 18, 18, 18 } };
    Matrix expectedMatrix = new Matrix(expected, 3, 3);
    Matrix actual = this.matrix1.multiply(this.matrix2);
    assertEquals(expectedMatrix, actual);
  }

  @Test
  public void shouldMultiplyTwoMatricesWithDifferentDimension() {
    int[][] m1 = { { 1, 2, 3 }, { 4, 5, 6 } };
    int[][] m2 = { { 7, 8 }, { 9, 10 }, { 11, 12 } };
    this.matrix1 = new Matrix(m1, 2, 3);
    this.matrix2 = new Matrix(m2, 3, 2);
    int[][] expected = { { 58, 64 }, { 139, 154 } };
    Matrix expectedMatrix = new Matrix(expected, 2, 2);
    Matrix actual = this.matrix1.multiply(this.matrix2);
    assertEquals(expectedMatrix, actual);
  }

  @Test
  public void shouldCheckIfValidMatrixDimensionForMultiply() {
    int[][] m1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 11, 12, 13 } };
    int[][] m2 = { { 7, 8 }, { 9, 10 } };
    this.matrix1 = new Matrix(m1, 3, 3);
    this.matrix2 = new Matrix(m2, 2, 2);
    Matrix actual = this.matrix1.multiply(this.matrix2);
    assertNull(actual);
  }

  @Test
  public void shouldGiveDeterminantOfMatrix() {
    int actual = this.matrix1.determinant();
    assertEquals(0, actual);
  }

  @Test
  public void shouldCheckIfTwoMatrixAreEqual() {
    boolean actual = this.matrix1.equals(this.matrix2);
    assertTrue(actual);
  }

  @Test
  public void shouldCheckIfTwoMatrixAreNotEqual() {
    int[][] m3 = { { 6, 6, 6 }, { 12, 12, 12 }, { 18, 18, 18 } };
    Matrix matrix3 = new Matrix(m3, 3, 3);
    boolean actual = this.matrix1.equals(m3);
    assertFalse(actual);
  }

  @Test
  public void shouldGiveStringRepresentationOfMatrix() {
    String actual = this.matrix1.toString();
    assertEquals(
      "[ \n  [ 1, 1, 1, ], \n  [ 2, 2, 2, ], \n  [ 3, 3, 3, ], \n]",
      actual
    );
  }
}
