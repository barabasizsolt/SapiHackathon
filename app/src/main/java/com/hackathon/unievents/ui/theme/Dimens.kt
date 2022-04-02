package com.hackathon.unievents.ui.theme

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

val phoneDimens = Dimens(
    screenPadding = 24.dp,
    smallPadding = 4.dp,
    contentPadding = 8.dp,
    buttonSize = 56.dp,
    welcomeImageContainerSize = 84.dp,
    welcomeIndicatorBottomMargin = 16.dp,
    welcomeIndicatorTopMargin = 16.dp
)

val tabletDimens = Dimens(
    screenPadding = 32.dp,
    smallPadding = 8.dp,
    contentPadding = 16.dp,
    buttonSize = 56.dp,
    welcomeImageContainerSize = 118.dp,
    welcomeIndicatorBottomMargin = 36.dp,
    welcomeIndicatorTopMargin = 24.dp
)

data class Dimens(
    val screenPadding: Dp = 16.dp,
    val smallPadding: Dp = 4.dp,
    val contentPadding: Dp = 8.dp,
    val contentPaddingFixed: Dp = 8.dp,
    val doubleContentPaddingFixed: Dp = 16.dp,
    val settingsItemContentPadding: Dp = 14.dp,
    val buttonSize: Dp = 56.dp,
    val welcomeImageContainerSize: Dp = 56.dp,
    val welcomeIndicatorBottomMargin: Dp = 0.dp,
    val welcomeIndicatorTopMargin: Dp = 0.dp,
    val dinoHeight: Dp = 130.dp,
    val dinoWidth: Dp = 80.dp,
    val wavingDinoHeight: Dp = 97.dp,
    val wavingDinoWidth: Dp = 59.dp,
    val bottomWavingDinoWidth: Dp = 180.dp,
    val bottomWavingDinoHeight: Dp = 174.dp,
    val homeScreenToolbarHeight: Dp = 84.dp,
    val avatarSize: Dp = 96.dp,
    val topAppBarElevation: Dp = 4.dp,
    val seriesLogoWidth: Dp = 276.dp,
    val seriesLogoHeight: Dp = 131.dp,
    val runtimePermissionVideoHeight: Dp = 220.dp,
    val subscriptionCardBestValueOffset: Dp = (-8).dp,
    val subscriptionCloseButtonSize: Dp = 45.dp,
    val subscriptionCloseButtonElevation: Dp = 10.dp,
    val subscriptionCardHeight: Dp = 185.dp,
    val subscriptionPlanDinoHeight: Dp = 75.dp,
    val subscriptionPlanDinoWidth: Dp = 85.dp,
)