package tz.co.hosannahighertech.restoapp.interfaces

import tz.co.hosannahighertech.restoapp.data.models.Hotel

/**
 * @package tz.co.hosannahighertech.restoapp
 * Created by Stefano D. Mtangoo <stefano@hosannahighertech.co.tz> on
 * Created at 23/10/2018 18:25.
 * Copyright (c) 2018, Hosanna Higher Technologies Co. Ltd
 * This Code is Provided under Hosanna HTCL Licensing Conditions.
 */
interface HotelClickListerner {
    fun onClick(hotel: Hotel)
}