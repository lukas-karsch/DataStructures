package karsch.lukas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

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
        assertEquals(expected, actual);
    }

    @Test
    void shouldAddAndGetCorrectValue() {
        arrayList.add(1);
        assertEquals(1, arrayList.get(0));
    }

    @Test
    @Disabled
    void remove() {
    }

    @Test
    @Disabled
    void containsAll() {
    }

    @Test
    @Disabled
    void addAll() {
    }

    @Test
    @Disabled
    void testAddAll() {
    }

    @Test
    @Disabled
    void removeAll() {
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