/*
 * Twidere - Twitter client for Android
 *
 *  Copyright (C) 2012-2015 Mariotaku Lee <mariotaku.lee@gmail.com>
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.mariotaku.twidere.util;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import org.mariotaku.twidere.fragment.card.CardBrowserFragment;
import org.mariotaku.twidere.fragment.card.CardPollFragment;
import org.mariotaku.twidere.model.ParcelableCardEntity;
import org.mariotaku.twidere.model.ParcelableStatus;
import org.mariotaku.twidere.model.util.ParcelableCardEntityUtils;

/**
 * Created by mariotaku on 15/1/1.
 */
public abstract class TwitterCardFragmentFactory {

    public abstract Fragment createAnimatedGifFragment(ParcelableCardEntity card);

    public abstract Fragment createAudioFragment(ParcelableCardEntity card);

    public abstract Fragment createPlayerFragment(ParcelableCardEntity card);

    public static TwitterCardFragmentFactory getInstance() {
        return new TwitterCardFragmentFactoryImpl();
    }

    @Nullable
    public static Fragment createGenericPlayerFragment(@Nullable ParcelableCardEntity card, Bundle args) {
        if (card == null) return null;
        final String playerUrl = ParcelableCardEntityUtils.getString(card, "player_url");
        if (playerUrl == null) return null;
        return CardBrowserFragment.show(playerUrl, args);
    }

    public static Fragment createCardPollFragment(ParcelableStatus status) {
        return CardPollFragment.show(status);
    }
}
