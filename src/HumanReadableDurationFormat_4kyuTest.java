import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HumanReadableDurationFormat_4kyuTest {

    @Test
    void formatDuration() {
        assertEquals("1 second", HumanReadableDurationFormat_4kyu.formatDuration(1));
        assertEquals("1 minute and 2 seconds", HumanReadableDurationFormat_4kyu.formatDuration(62));
        assertEquals("2 minutes", HumanReadableDurationFormat_4kyu.formatDuration(120));
        assertEquals("1 hour", HumanReadableDurationFormat_4kyu.formatDuration(3600));
        assertEquals("1 hour, 1 minute and 2 seconds", HumanReadableDurationFormat_4kyu.formatDuration(3662));
        assertEquals("4 years, 68 days, 3 hours and 4 minutes", HumanReadableDurationFormat_4kyu.formatDuration(132030240));
    }
}