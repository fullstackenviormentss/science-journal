/*
 *  Copyright 2016 Google Inc. All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.google.android.apps.forscience.whistlepunk;

import android.util.Log;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.MessageNano;

import java.io.IOException;

public class ProtoUtils {
    private static final String TAG = "proto_utils";

    public static byte[] makeBlob(MessageNano proto) {
        int serializedSize = proto.getSerializedSize();
        byte[] output = new byte[serializedSize];

        CodedOutputByteBufferNano buffer = CodedOutputByteBufferNano.newInstance(output);
        try {
            proto.writeTo(buffer);
        } catch (IOException e) {
            Log.e(TAG, "Could not serialize config", e);
        }

        return output;
    }
}
