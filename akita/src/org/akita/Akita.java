/*
 * Copyright 1999-2101 Alibaba Group.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *      http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.akita;

import org.akita.proxy.ProxyFactory;

/**
 * Created with IntelliJ IDEA.
 * User: justin
 * Date: 12-4-3
 * Time: 下午4:44
 */
public class Akita {
    public static final String XMLNS = "http://schemas.akita.org/apk/res/android";
    public static final String UTF_8 = "UTF-8";

    public enum UseHttpLib {
        HTTP_CLIENT,
        HTTP_URL_CONNECTION
    }
    /**
     * HttpClient or
     * HttpUrlConnection
     */
    public static UseHttpLib USE_HTTP_LIB = UseHttpLib.HTTP_CLIENT;

    public static <T> T createAPI(Class<T> clazz) {
        return ProxyFactory.getProxy(clazz);
    }

}
