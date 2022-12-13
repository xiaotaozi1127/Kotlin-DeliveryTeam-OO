package deliveryteaminkotlin

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class BATest {
    @Test fun ba_should_be_able_to_prepare_story_and_assign_card() {
        val team = Team()
        val ba = BA("xixi")
        val dev = Dev("yanmin")
        team.assignMember(ba)
        team.assignMember(dev)
        val story = Story("fix bug")
        team.assignStory(story)

        ba.work()

        assertEquals(story, dev.assignedStory)
    }
}
