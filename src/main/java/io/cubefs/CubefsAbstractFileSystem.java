// Copyright 2022 The CubeFS Authors.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
// implied. See the License for the specific language governing
// permissions and limitations under the License.

package io.cubefs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.DelegateToFileSystem;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class CubefsAbstractFileSystem extends DelegateToFileSystem {
    public CubefsAbstractFileSystem(URI theUri, Configuration conf) throws IOException, URISyntaxException {
        super(theUri, new CubefsFileSystem(), conf, theUri.getScheme(), false);
    }

    @Override
    public int getUriDefaultPort() {
        return -1;
    }
}