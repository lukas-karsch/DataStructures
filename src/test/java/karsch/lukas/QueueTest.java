package karsch.lukas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    private Queue<Integer> queue;

    @BeforeEach
    void setUp() {
        queue = new Queue<>();
    }

    @Test
    void queueShouldBeEmptyInitially() {
        assertTrue(queue.isEmpty());
    }

    @Test
    void emptyQueueShouldPollNull() {
        assertNull(queue.poll());
    }

    @Test
    void emptyQueueShouldPeekNull() {
        assertNull(queue.peek());
    }

    @Test
    void shouldPollCorrectFirstValue() {
        //when
        queue.add(10);
        //expect
        assertEquals(10, queue.poll());
    }

    @Test
    void shouldPeekCorrectFirstValue() {
        //when
        queue.add(10);
        //expect
        assertEquals(10, queue.peek());
    }

    @Test
    void queueShouldBeEmptyAfterPollingAll() {
        //given
        queue.add(10);
        //when
        queue.poll();
        //expect
        assertTrue(queue.isEmpty());
        assertNull(queue.peek());
    }

    @Test
    void shouldPollCorrectValuesMultiple() {
        //given
        queue.add(1);
        queue.add(2);
        queue.add(3);
        //expect
        assertAll(
                () -> assertEquals(1, queue.poll()),
                () -> assertEquals(2, queue.poll()),
                () -> assertEquals(3, queue.poll())
        );
    }
}
