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
import org.jetbrains.compose.resources.painterResource
import skilonline.composeapp.generated.resources.Res
import skilonline.composeapp.generated.resources.skil_logo

@Composable
fun PremiumFooter(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
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
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 32.dp),
            verticalArrangement = Arrangement.spacedBy(40.dp)
        ) {
            @OptIn(androidx.compose.foundation.layout.ExperimentalLayoutApi::class)
            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalArrangement = Arrangement.spacedBy(40.dp)
            ) {
                // Column 1: Brand & Contact
                Column(
                    modifier = Modifier.widthIn(min = 250.dp, max = 300.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    androidx.compose.foundation.Image(
                        painter = painterResource(Res.drawable.skil_logo),
                        contentDescription = "SKIL Logo",
                        modifier = Modifier.height(40.dp),
                        contentScale = androidx.compose.ui.layout.ContentScale.Fit
                    )
                    
                    Text(
                        text = "STEP INTO EXCELLENCE",
                        fontWeight = FontWeight.Medium,
                        fontSize = 11.sp,
                        color = AppColors.AccentGold,
                        letterSpacing = 2.sp
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        Text(
                            text = "skillifestyle.vizag@gmail.com",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = AppColors.TextPrimary
                        )
                        Text(
                            text = "www.skillifestyle.in",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = AppColors.TextPrimary
                        )
                    }
                }

                // Column 2: Registered Office
                Column(
                    modifier = Modifier.widthIn(min = 220.dp, max = 280.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
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
                            fontSize = 11.sp,
                            color = AppColors.TextPrimary,
                            letterSpacing = 1.sp
                        )
                    }
                    Text(
                        text = "7-14(1)-9, AST 1085003765,\n2nd Floor, New Colony, Srikakulam II Town,\nSrikakulam, Srikakulam - 532001,\nAndhra Pradesh",
                        fontSize = 12.sp,
                        color = AppColors.TextSecondary,
                        lineHeight = 20.sp
                    )
                }

                // Column 3: Principal Place of Business
                Column(
                    modifier = Modifier.widthIn(min = 220.dp, max = 280.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
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
                            fontSize = 11.sp,
                            color = AppColors.TextPrimary,
                            letterSpacing = 1.sp
                        )
                    }
                    Text(
                        text = "Shop No.7A, D.No. 28-10-4, Third Floor,\nVasavi Plaza, Theatre Road, Revenue Ward No.27,\nJagadamba Jn, Visakhapatnam - 530020, AP",
                        fontSize = 12.sp,
                        color = AppColors.TextSecondary,
                        lineHeight = 20.sp
                    )
                }
            }
        }
        
        // Bottom Copyright Bar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(AppColors.SurfaceBackground)
                .border(width = 1.dp, color = AppColors.BorderLight)
                .padding(vertical = 16.dp, horizontal = 24.dp)
        ) {
            Text(
                text = "© 2024 SKIL Lifestyle. All rights reserved.",
                fontSize = 11.sp,
                color = AppColors.TextSecondary,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}
