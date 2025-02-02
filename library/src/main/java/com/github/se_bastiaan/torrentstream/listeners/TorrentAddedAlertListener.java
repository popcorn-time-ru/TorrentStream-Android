/*
 * Copyright (C) 2015-2018 Sébastiaan (github.com/se-bastiaan)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.se_bastiaan.torrentstream.listeners;

import org.libtorrent4j.AlertListener;
import org.libtorrent4j.alerts.AddTorrentAlert;
import org.libtorrent4j.alerts.Alert;
import org.libtorrent4j.alerts.AlertType;

public abstract class TorrentAddedAlertListener implements AlertListener {
    @Override
    public int[] types() {
        return new int[]{AlertType.ADD_TORRENT.swig()};
    }

    @Override
    public void alert(Alert<?> alert) {
        switch (alert.type()) {
            case ADD_TORRENT:
                torrentAdded((AddTorrentAlert) alert);
                break;
            default:
                break;
        }
    }

    public abstract void torrentAdded(AddTorrentAlert alert);
}
