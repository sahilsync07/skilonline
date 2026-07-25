package com.skil.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skil.app.theme.AppColors

@Composable
fun PremiumFooter(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 40.dp, bottom = 20.dp)
            .background(Color.White)
            .border(width = 1.dp, color = AppColors.BorderLight)
    ) {
        // Gold Accent Line
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(4.dp)
                .background(AppColors.AccentGold)
        )

        Column(
            modifier = Modifier.padding(32.dp),
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            // Address Section
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                // Registered Office
                Column(modifier = Modifier.weight(1f)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(6.dp)
                                .background(AppColors.AccentGold, shape = RoundedCornerShape(99.dp))
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "REGISTERED OFFICE",
                            fontWeight = FontWeight.Bold,
                            fontSize = 10.sp,
                            color = AppColors.TextPrimary,
                            letterSpacing = 1.sp
                        )
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "7-14(1)-9, AST 1085003765,\n2nd Floor, New Colony, Srikakulam II Town,\nSrikakulam, Srikakulam - 532001, Andhra Pradesh",
                        fontSize = 10.sp,
                        color = AppColors.TextSecondary,
                        lineHeight = 16.sp
                    )
                }

                // Principal Place of Business
                Column(modifier = Modifier.weight(1f)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(6.dp)
                                .background(AppColors.AccentGold, shape = RoundedCornerShape(99.dp))
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "PRINCIPAL PLACE OF BUSINESS",
                            fontWeight = FontWeight.Bold,
                            fontSize = 10.sp,
                            color = AppColors.TextPrimary,
                            letterSpacing = 1.sp
                        )
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "Shop No.7A, D.No. 28-10-4, Third Floor,\nVasavi Plaza, Theatre Road, Revenue Ward No.27,\nJagadamba Jn, Visakhapatnam - 530020, AP",
                        fontSize = 10.sp,
                        color = AppColors.TextSecondary,
                        lineHeight = 16.sp
                    )
                }
            }

            // Divider
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(AppColors.BorderLight)
            )

            // Contact Info
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "+91 93483 43310 | +91 79895 36155",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = AppColors.TextPrimary
                )
                Text(
                    text = "skillifestyle.vizag@gmail.com",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = AppColors.TextPrimary
                )
                Text(
                    text = "www.skillifestyle.in",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = AppColors.TextPrimary
                )
            }

            // Tagline
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .width(40.dp)
                        .height(1.dp)
                        .background(AppColors.AccentGold)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "STEP INTO EXCELLENCE",
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    color = AppColors.TextPrimary,
                    letterSpacing = 2.sp
                )
                Spacer(modifier = Modifier.width(16.dp))
                Box(
                    modifier = Modifier
                        .width(40.dp)
                        .height(1.dp)
                        .background(AppColors.AccentGold)
                )
            }
        }
    }
}
