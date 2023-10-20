package karsch.lukas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {
    private ArrayList<Integer> arrayList;

    @BeforeEach
    void setUp() {
        arrayList = new ArrayList<>();
    }

    @Test
    void sizeShouldBeZeroInitially() {
        assertEquals(0, arrayList.size());
    }

    @Test
    void sizeShouldBeOneAfterAddingOneElement() {
        //when
        arrayList.add(1);
        //expect
        assertEquals(1, arrayList.size());
    }

    @Test
    void shouldBeEmptyInitially() {
        assertTrue(arrayList.isEmpty());
    }

    @Test
    void shouldNotBeEmptyAfterAdding() {
        arrayList.add(1);
        assertFalse(arrayList.isEmpty());
    }

    @Test
    void shouldBeEmptyAfterRemovingAllElements() {
        arrayList.add(1);
        assertFalse(arrayList.isEmpty());
        arrayList.remove(0);
        assertTrue(arrayList.isEmpty());
    }

    @Test
    void shouldBeEmptyAfterClearing() {
        arrayList.add(1);
        arrayList.clear();
        assertTrue(arrayList.isEmpty());
    }

    @Test
    void shouldContainElementLengthOne() {
        arrayList.add(1);
        assertTrue(arrayList.contains(1));
    }

    @Test
    void shouldContainElementsLongerList() {
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        assertAll(
                () -> assertTrue(arrayList.contains(1)),
                () -> assertTrue(arrayList.contains(2)),
                () -> assertTrue(arrayList.contains(3)),
                () -> assertTrue(arrayList.contains(4))
        );
    }

    @Test
    void shouldNotContainWrongElements() {
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        assertFalse(arrayList.contains(5));
    }

    @Test
    void shouldNotContainElementEmptyList() {
        assertFalse(arrayList.contains(1));
    }

    @Test
    void shouldProduceCorrectObjectArray() {
        final Object[] expected = new Object[]{1, 2, 3};
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        final Object[] actual = arrayList.toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnSameArrayWithCorrectContentIfLengthIdentical() {
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        Integer[] empty = new Integer[3];
        Integer[] actual = arrayList.toArray(empty);
        Integer[] expected = new Integer[]{1, 2, 3};
        assertArrayEquals(expected, actual);
        assertSame(empty, actual);
    }

    @Test
    void shouldReturnCorrectArrayWhenLengthTooShort() {
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        Integer[] actual = arrayList.toArray(new Integer[2]);
        Integer[] expected = new Integer[]{1, 2, 3};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFillArrayWithNull() {
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        Integer[] actual = arrayList.toArray(new Integer[4]);
        Integer[] expected = new Integer[]{1, 2, 3, null};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddAndGetCorrectValue() {
        arrayList.add(1);
        assertEquals(1, arrayList.get(0));
    }

    @Test
    void shouldRemoveObjectAndReturnTrue() {
        var stringArrayList = new ArrayList<String>();
        String s1 = "First";
        String s2 = "String";
        String s3 = "Test";
        stringArrayList.add(s1);
        stringArrayList.add(s2);
        stringArrayList.add(s3);
        ArrayList<String> expected = new ArrayList<>();
        expected.add(s1);
        expected.add(s2);
        boolean result = stringArrayList.remove(s3);
        assertEquals(expected, stringArrayList);
        assertTrue(result);
    }

    @Test
    void shouldNotRemoveWrongObjectAndReturnFalse() {
        boolean result = arrayList.remove(new Object());
        assertFalse(result);
    }

    @Test
    void shouldRemoveIndexFromEnd() {
        var stringArrayList = new ArrayList<String>();
        String s1 = "First";
        String s2 = "String";
        String s3 = "Test";
        stringArrayList.add(s1);
        stringArrayList.add(s2);
        stringArrayList.add(s3);
        var expected = new ArrayList<String>();
        expected.add(s1);
        expected.add(s2);
        String removed = stringArrayList.remove(2);
        assertEquals(expected, stringArrayList);
        assertEquals(s3, removed);
    }

    @Test
    void shouldRemoveIndexFromMiddle() {
        var stringArrayList = new ArrayList<String>();
        String s1 = "First";
        String s2 = "String";
        String s3 = "Test";
        stringArrayList.add(s1);
        stringArrayList.add(s2);
        stringArrayList.add(s3);
        var expected = new ArrayList<String>();
        expected.add(s1);
        expected.add(s3);
        String removed = stringArrayList.remove(1);
        assertEquals(expected, stringArrayList);
        assertEquals(s2, removed);
    }

    @Test
    void equalListsShouldBeEqual() {
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        ArrayList<Integer> compare = new ArrayList<>();
        compare.add(1);
        compare.add(2);
        compare.add(3);
        assertEquals(arrayList, compare);
    }

    @Test
    void unequalListsShouldNotBeEqual() {
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        ArrayList<Integer> compare = new ArrayList<>();
        compare.add(2);
        compare.add(3);
        compare.add(4);
        assertNotEquals(arrayList, compare);
    }

    @Test
    void similarListsDifferentLengthsNotEqual() {
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        ArrayList<Integer> compare = new ArrayList<>();
        compare.add(1);
        compare.add(2);
        compare.add(3);
        compare.add(4);
        assertNotEquals(arrayList, compare);
    }

    @Test
    void shouldContainAll() {
        var stringArrayList = new ArrayList<String>();
        String s1 = "ABc";
        String s2 = "BCE";
        String s3 = "Stuttgart";
        stringArrayList.add(s1);
        stringArrayList.add(s2);
        stringArrayList.add(s3);
        Collection<String> collection = new java.util.ArrayList<>(List.of(s1, s2, s3));
        assertTrue(stringArrayList.containsAll(collection));
    }

    @Test
    void shouldNotContainAll() {
        var stringArrayList = new ArrayList<String>();
        String s1 = "ABc";
        String s2 = "BCE";
        String s3 = "Stuttgart";
        String s4 = "Not in list";
        stringArrayList.add(s1);
        stringArrayList.add(s2);
        stringArrayList.add(s3);
        Collection<String> collection = new java.util.ArrayList<>(List.of(s1, s2, s3, s4));
        assertFalse(stringArrayList.containsAll(collection));
    }

    @Test
    void addOneWithIndex() {
        arrayList.add(1);
        arrayList.add(2);
        var expected = new ArrayList<Integer>();
        expected.add(1);
        expected.add(4);
        expected.add(2);
        //when
        arrayList.add(1, 4);
        //expect
        assertEquals(expected, arrayList);
    }

    @Test
    void addSeveralWithIndex() {
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        var expected = new ArrayList<Integer>();
        expected.add(1);
        expected.add(4);
        expected.add(2);
        expected.add(5);
        expected.add(3);
        //when
        arrayList.add(1, 4);
        arrayList.add(3, 5);
        //expect
        assertEquals(expected, arrayList);
    }

    @Test
    void addAllEmptyCollectionShouldReturnFalse() {
        assertFalse(arrayList.addAll(new java.util.ArrayList<>()));
        assertFalse(arrayList.addAll(2, new java.util.ArrayList<>()));
    }

    @Test
    void addAllShouldReturnTrue() {
        var c = new java.util.ArrayList<>(List.of(1, 2));
        var result1 = arrayList.addAll(c);
        var result2 = arrayList.addAll(1, c);
        assertTrue(result1);
        assertTrue(result2);
    }

    @Test
    void addAllToEnd() {
        arrayList.add(1);
        arrayList.add(2);
        var c = new java.util.ArrayList<>(List.of(3, 4, 5));
        arrayList.addAll(c);
        var expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(5);
        assertEquals(expected, arrayList);
    }

    @Test
    void testAddAllToMiddle() {
        arrayList.add(1);
        arrayList.add(2);
        var c = new java.util.ArrayList<>(List.of(3, 4, 5));
        arrayList.addAll(1, c);
        var expected = new ArrayList<>();
        expected.add(1);
        expected.add(3);
        expected.add(4);
        expected.add(5);
        expected.add(2);
        assertEquals(expected, arrayList);
    }

    @Test
    void shouldRemoveAll() {
        var stringArrayList = new ArrayList<String>();
        String s1 = "foo";
        String s2 = "bar";
        String s3 = "lee";
        String s4 = "bob";
        stringArrayList.addAll(List.of(s1, s2, s3, s4));
        //when
        boolean result = stringArrayList.removeAll(List.of(s1, s2));
        //expect
        var expected = new ArrayList<String>();
        expected.addAll(List.of(s3, s4));
        assertEquals(expected, stringArrayList);
        assertTrue(result);
    }

    @Test
    void removeAllNoModificationShouldReturnFalse() {
        assertFalse(arrayList.removeAll(List.of(1,2)));
    }

    @Test
    @Disabled
    void retainAll() {
    }

    @Test
    @Disabled
    void clear() {
    }

    @Test
    @Disabled
    void get() {
    }

    @Test
    @Disabled
    void set() {
    }

    @Test
    @Disabled
    void testAdd() {
    }

    @Test
    @Disabled
    void testRemove() {
    }

    @Test
    void shouldReturnCorrectIndexOfElement() {
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(3);
        arrayList.add(2);
        arrayList.add(1);
        assertAll(
                () -> assertEquals(0, arrayList.indexOf(1)),
                () -> assertEquals(1, arrayList.indexOf(2)),
                () -> assertEquals(2, arrayList.indexOf(3)),
                () -> assertEquals(3, arrayList.indexOf(4))
        );
    }

    @Test
    void shouldReturnCorrectLastIndex() {
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(3);
        arrayList.add(2);
        arrayList.add(1);
        arrayList.add(4);
        assertAll(
                () -> assertEquals(7, arrayList.lastIndexOf(4)),
                () -> assertEquals(6, arrayList.lastIndexOf(1)),
                () -> assertEquals(5, arrayList.lastIndexOf(2)),
                () -> assertEquals(4, arrayList.lastIndexOf(3))
        );
    }

    @Test
    void shouldReturnNegativeOneWhenElementNotInList() {
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        assertEquals(-1, arrayList.indexOf(4));
        assertEquals(-1, arrayList.lastIndexOf(4));
    }

    @Test
    @Disabled
    void subList() {
    }
}