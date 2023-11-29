package me.iksad.optimizer.service;

import lombok.extern.slf4j.Slf4j;
import me.iksad.optimizer.dto.MemberResponse;
import me.iksad.optimizer.utils.LoadEnvironmentVariables;
import me.iksad.optimizer.utils.StressTestUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
@LoadEnvironmentVariables
class MemberServiceImplTest {
    @Autowired
    private MemberServiceImpl memberService;

    @Autowired
    private FetchJoinMemberServiceImpl fetchJoinMemberService;

    @Autowired
    private EntityGraphMemberServiceImpl entityGraphMemberService;

    @Test
    void readWishList() {
        // given
        Long id = 1L;

        // when
        MemberResponse memberResponse = memberService.readMemberInfo(id);

        // then
        log.info(String.valueOf(memberResponse));
        log.info(String.valueOf(memberResponse.wishList().size()));
    }

    @Test
    void readWishList_atFetchJoinMemberServiceImpl() {
        // given
        Long id = 1L;

        // when
        MemberResponse memberResponse = fetchJoinMemberService.readMemberInfo(id);

        // then
        log.info(String.valueOf(memberResponse));
        log.info(String.valueOf(memberResponse.wishList().size()));
    }

    @Test
    void readWishList_atEntityGraphMemberServiceImpl() {
        // given
        Long id = 1L;

        // when
        MemberResponse memberResponse = entityGraphMemberService.readMemberInfo(id);

        // then
        log.info(String.valueOf(memberResponse));
        log.info(String.valueOf(memberResponse.wishList().size()));
    }

    @Test
    void record_time_readWishList() throws Throwable {
        // given
        int number_of_try = 1000;
        Long id = 1L;

        // when
        long runningTime = StressTestUtil.multipleCall(
                number_of_try,
                () -> memberService.readMemberInfo(id)
        );

        // then
        log.info(String.valueOf(runningTime));
    }

    @Test
    void record_time_readWishList_atFetchJoinMemberServiceImpl() throws Throwable {
        // given
        int number_of_try = 1000;
        Long id = 1L;

        // when
        long runningTime = StressTestUtil.multipleCall(
                number_of_try,
                () -> fetchJoinMemberService.readMemberInfo(id)
        );

        // then
        log.info(String.valueOf(runningTime));
    }

    @Test
    void record_time_readWishList_atEntityGraphMemberServiceImpl() throws Throwable {
        // given
        int number_of_try = 1000;
        Long id = 1L;

        // when
        long runningTime = StressTestUtil.multipleCall(
                number_of_try,
                () -> entityGraphMemberService.readMemberInfo(id)
        );

        // then
        log.info(String.valueOf(runningTime));
    }
}