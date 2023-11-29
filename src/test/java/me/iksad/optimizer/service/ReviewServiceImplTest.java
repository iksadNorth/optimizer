package me.iksad.optimizer.service;

import lombok.extern.slf4j.Slf4j;
import me.iksad.optimizer.dto.ReviewAvgResponse;
import me.iksad.optimizer.dto.ReviewResponse;
import me.iksad.optimizer.utils.LoadEnvironmentVariables;
import me.iksad.optimizer.utils.StressTestUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
@LoadEnvironmentVariables
class ReviewServiceImplTest {
    @Autowired
    private ReviewServiceImpl reviewService;

    @Autowired
    private EnhancedReviewServiceImpl enhancedReviewService;

    @Test
    void record_time_readItemAvgRating() throws Throwable {
        // given
        int number_of_try = 1000;
        Long id = 6L;

        // when
        long runningTime = StressTestUtil.multipleCall(
                number_of_try,
                () -> reviewService.readItemAvgRating(id)
        );

        // then
        log.info(String.valueOf(runningTime));
    }

    @Test
    void record_time_readItemAvgRating_atEnhancedReviewServiceImpl() throws Throwable {
        // given
        int number_of_try = 1000;
        Long id = 6L;

        // when
        long runningTime = StressTestUtil.multipleCall(
                number_of_try,
                () -> enhancedReviewService.readItemAvgRating(id)
        );

        // then
        log.info(String.valueOf(runningTime));
    }

    @Test
    void record_time_readReviews() throws Throwable {
        // given
        int number_of_try = 50;

        // when
        long runningTime = StressTestUtil.multipleCall(
                number_of_try,
                () -> reviewService.readReviews()
        );

        // then
        log.info(String.valueOf(runningTime));
    }

    @Test
    void record_time_readReviews_atEnhancedReviewServiceImpl() throws Throwable {
        // given
        int number_of_try = 50;

        // when
        long runningTime = StressTestUtil.multipleCall(
                number_of_try,
                () -> enhancedReviewService.readReviews()
        );

        // then
        log.info(String.valueOf(runningTime));
    }
}