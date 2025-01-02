package ru.job4j.assertj;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {

    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisTetrahedron() {
        Box box = new Box(4, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Tetrahedron");
    }

    @Test
    void HowManyIsNumberOfVerticesSphere() {
        Box box = new Box(0, 10);
        Integer number = box.getNumberOfVertices();
        assertThat(number).isEqualTo(0);
    }

    @Test
    void HowManyIsNumberOfVerticesTetrahedron() {
        Box box = new Box(4, 10);
        Integer number = box.getNumberOfVertices();
        assertThat(number).isEqualTo(4);
    }

    @Test
    void isExistTestFalse() {
        Box box = new Box(2, 10);
        boolean boo = box.isExist();
        assertThat(boo).isEqualTo(false);
    }

    @Test
    void isExistTestTrue() {
        Box box = new Box(0, 10);
        boolean boo = box.isExist();
        assertThat(boo).isEqualTo(true);
    }

    @Test
    void AreaSphere() {
        Box box = new Box(0, 10);
        double area = box.getArea();
        assertThat(area).isEqualTo(1256.637d, withPrecision(0.001d))
                .isCloseTo(1256.637d, withPrecision(0.001d))
                .isCloseTo(1256.637d, Percentage.withPercentage(0.001d))
                .isGreaterThan(1256.636d)
                .isLessThan(1256.638d);
    }

    @Test
    void AreaCube() {
        Box box = new Box(8, 10);
        double area = box.getArea();
        assertThat(area).isEqualTo(600.0d, withPrecision(0.1d))
                .isCloseTo(600.0d, withPrecision(0.1d))
                .isCloseTo(600.0d, Percentage.withPercentage(0.1d))
                .isGreaterThan(599.9d)
                .isLessThan(600.1d);
    }

}