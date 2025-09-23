package com.quickboard.apicomposer.common.feign.client;

import com.quickboard.apicomposer.board.dto.BoardAdminResponse;
import com.quickboard.apicomposer.board.dto.BoardResponse;
import com.quickboard.apicomposer.common.dto.PagedResponse;
import com.quickboard.apicomposer.common.feign.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "resource-board", configuration = FeignConfig.class)
public interface BoardClient {
    @GetMapping("/rsc/v1/boards")
    PagedResponse<BoardResponse> getBoards(@RequestParam(value = "keyword", required = false)String keyword,
                                           @RequestParam(value = "size", required = false) Long size,
                                           @RequestParam(value = "sort", required = false) String sort);

    @GetMapping("/rsc/v1/boards/{id}/board-admins")
    PagedResponse<BoardAdminResponse> getBoardAdmins(@PathVariable("id") Long boardId,
                                                     @RequestParam(value = "size", required = false) Long size,
                                                     @RequestParam(value = "sort", required = false) String sort);

}
