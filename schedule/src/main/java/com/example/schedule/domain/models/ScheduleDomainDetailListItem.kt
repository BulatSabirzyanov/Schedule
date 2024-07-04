package com.example.schedule.domain.models

import java.util.Date

/**
 * @author b.sabirzyanov
 */
data class ScheduleDomainDetailListItem(
    val id: String,
    val date: Date,
    val title: String,
    val resolved: Boolean,
    val favorite: Boolean
)
