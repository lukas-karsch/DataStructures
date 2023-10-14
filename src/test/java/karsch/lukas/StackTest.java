package karsch.lukas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    private Stack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new Stack<>();
    }

    @Test
    void sizeShouldBeZeroInitially() {
        assertEquals(0, stack.size());
    }

    @Test
    void emptyStackShouldThrowWhenPopping() {
        assertThrows(EmptyStackException.class, () -> stack.pop());
    }

    @Test
    void emptyStackShouldThrowWhenPeeking() {
        assertThrows(EmptyStackException.class, () -> stack.peek());
    }

    @Test
    void stackSizeShouldUpdateWhenPushing() {
        assertAll(
                () -> {
                    stack.push(1);
                    assertEquals(1, stack.size());
                },
                () -> {
                    stack.push(2);
                    assertEquals(2, stack.size());
                }
        );
    }

    @Test
    void shouldPopCorrectValue() {
        //when
        int element = 2;
        stack.push(element);
        //expect
        assertEquals(element, stack.pop());
    }

    @Test
    void shouldPopCorrectValueMultiple() {
        //when
        stack.push(1);
        stack.push(2);
        stack.push(3);
        //expect
        assertAll(
                () -> assertEquals(3, stack.pop()),
                () -> assertEquals(2, stack.pop()),
                () -> assertEquals(1, stack.pop())
        );
    }

    @Test
    void shouldPeekCorrectValue() {
        //when
        int element = 2;
        stack.push(element);
        //expect
        assertEquals(element, stack.peek());
    }

    @Test
    void shouldUpdateSizeWhenPopping() {
        assertAll(
                () -> {
                    //given
                    stack.push(2);
                    //When
                    stack.pop();
                    //expect
                    assertEquals(0, stack.size());
                },
                () -> {
                    //given
                    stack.push(2);
                    stack.push(3);
                    //When
                    stack.pop();
                    //expect
                    assertEquals(1, stack.size());
                });
    }

    @Test
    void shouldIncreaseCapacity() {
        stack = new Stack<>(1);
        stack.push(1);
        //stack is full and should scale up
        assertDoesNotThrow(() -> stack.push(10));
        assertEquals(2, stack.size());
    }
}