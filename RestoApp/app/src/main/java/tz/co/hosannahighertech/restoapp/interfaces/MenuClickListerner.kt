package tz.co.hosannahighertech.restoapp.interfaces

import tz.co.hosannahighertech.restoapp.data.models.HotelMenu

/**
 * @package tz.co.hosannahighertech.restoapp.interfaces
 * Created by Stefano D. Mtangoo <stefano@hosannahighertech.co.tz> on
 * Created at 23/10/2018 21:15.
 * Copyright (c) 2018, Hosanna Higher Technologies Co. Ltd
 * This Code is Provided under Hosanna HTCL Licensing Conditions.
 */
interface MenuClickListerner {
    fun onClick(menu: HotelMenu)
}