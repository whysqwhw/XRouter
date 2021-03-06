/*
 * Copyright (C) 2018 xuexiangjys(xuexiangjys@163.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.xuexiang.xrouter.facade.service;

import com.xuexiang.xrouter.facade.template.IProvider;

import java.lang.reflect.Type;

/**
 * 序列化服务
 *
 * @author xuexiang
 * @since 2018/5/17 上午1:04
 */
public interface SerializationService extends IProvider {

    /**
     * 对象序列化为json
     *
     * @param instance obj
     * @return json string
     */
    String object2Json(Object instance);

    /**
     * json反序列化为对象
     *
     * @param input json string
     * @param clazz object type
     * @return instance of object
     */
    <T> T parseObject(String input, Type clazz);
}
