package me.iksad.optimizer.service;

import lombok.extern.slf4j.Slf4j;
import me.iksad.optimizer.dto.ItemRequest;
import me.iksad.optimizer.dto.ItemResponse;
import me.iksad.optimizer.entity.Item;
import me.iksad.optimizer.repository.ItemRepository;
import me.iksad.optimizer.utils.LoadEnvironmentVariables;
import me.iksad.optimizer.utils.StressTestUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@SpringBootTest
@LoadEnvironmentVariables
class ItemServiceImplTest {

    @Autowired
    private ItemServiceImpl itemService;

    @Autowired
    private ItemRepository itemRepository;

    private final Random random = new Random();

    @Test
    void record_time_readById() throws Throwable {
        // given
        int number_of_try = 1000;
        Long id = 100L;

        // when
        long runningTime = StressTestUtil.multipleCall(
                number_of_try,
                () -> itemService.readById(id)
        );

        // then
        log.info(String.valueOf(runningTime));
    }

    @Test
    void record_time_readByIdWithCaching() throws Throwable {
        // given
        int number_of_try = 1000;
        Long id = 100L;

        // when
        long runningTime = StressTestUtil.multipleCall(
                number_of_try,
                () -> itemService.readByIdWithCaching(id)
        );

        // then
        log.info(String.valueOf(runningTime));
    }

    @Test
    void record_time_search() throws Throwable {
        // given
        int number_of_try = 100;
        String name = "빨간색 면 재질 드레스 M";
        Pageable pageable = PageRequest.of(0, 10);

        // when
        long runningTime = StressTestUtil.multipleCall(
                number_of_try,
                () -> itemService.search(name, pageable)
        );

        // then
        log.info(String.valueOf(runningTime));
    }

    private ItemRequest getRandomItemFixture() {
        Integer price = random.nextInt(100000);
        return new ItemRequest("record_time_create " + price, price);
    }

    @Test
    void record_time_create() throws Throwable {
        // given
        int number_of_try = 10000;

        ArrayList<ItemRequest> requests = new ArrayList<>();
        for (int i = 0; i <number_of_try; i++) {
            requests.add(getRandomItemFixture());
        }

        ArrayList<ItemResponse> saved = new ArrayList<>();

        // when
        long runningTime = StressTestUtil.recordTimeLap(() ->
            requests.forEach(itemRequest -> {
                ItemResponse response = itemService.create(itemRequest);
                saved.add(response);
            })
        );

        // then
        log.info(String.valueOf(runningTime));
        // 저장된 엔티티 삭제.
        List<Item> savedList = saved.stream()
                .map(ItemResponse::toEntity)
                .toList();
        itemRepository.deleteAll(savedList);
    }
}