/*
 * Copyright © 2013-2016 BLT, Co., Ltd. All Rights Reserved.
 */

package com.blt.talk.message.server.remote;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.blt.talk.common.model.BaseModel;
import com.blt.talk.common.model.entity.SessionEntity;
import com.blt.talk.common.param.SessionAddReq;
import com.blt.talk.common.param.SessionUpdateReq;

/**
 * 
 * @author 袁贵
 * @version 1.0
 * @since  1.0
 */
@FeignClient("talk-db-server")
public interface RecentSessionService {

    @GetMapping(path = "/session/recentSession")
    BaseModel<List<SessionEntity>> getRecentSession(@RequestParam("userId") long userId, @RequestParam("updateTime") int lastUpdateTime);
    @GetMapping(path = "/session/sessionId")
    BaseModel<Long> getSessionId(@RequestParam("userId") long userId, @RequestParam("peerId") long peerId,
            @RequestParam("type") int type, @RequestParam("isAll") boolean isAll);
    @PostMapping(path = "/session/addSession")
    BaseModel<Long> addSession(@RequestBody SessionAddReq sessionReq);
    @PostMapping(path = "/session/updateSession")
    BaseModel<?> updateSession(@RequestBody SessionUpdateReq sessionReq);
    @DeleteMapping(path = "/session/removeSession")
    BaseModel<?> removeSession(@RequestParam("sessionId") int sessionId);
}