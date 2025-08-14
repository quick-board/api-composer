package com.quickboard.apicomposer.common.feign;

import com.quickboard.apicomposer.board.dto.BoardAdminResponse;
import com.quickboard.apicomposer.board.dto.BoardResponse;
import com.quickboard.apicomposer.common.dto.PagedResponse;
import com.quickboard.apicomposer.common.enums.Direction;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "boardClient", url = "http://resource-board")
public interface BoardClient {
    @GetMapping("/rsc/v1/boards")
    PagedResponse<BoardResponse> getBoards(@RequestParam(value = "keyword", required = false)String keyword,
                                           @RequestParam(value = "size", required = false) Long size,
                                           @RequestParam(value = "sort", required = false) String sort,
                                           @RequestParam(value = "direction", required = false) Direction direction);

    @GetMapping("/rsc/v1/boards/{id}/board-admins")
    PagedResponse<BoardAdminResponse> getBoardAdmins(@PathVariable("id") Long boardId,
                                                     @RequestParam(value = "size", required = false) Long size,
                                                     @RequestParam(value = "sort", required = false) String sort,
                                                     @RequestParam(value = "direction", required = false) Direction direction);

}
