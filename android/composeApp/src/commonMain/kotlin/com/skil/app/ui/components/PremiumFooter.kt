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
                .padding(horizontal = 24.dp, vertical = 48.dp),
            verticalArrangement = Arrangement.spacedBy(48.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Grid of 2 Address Columns
            @OptIn(androidx.compose.foundation.layout.ExperimentalLayoutApi::class)
            FlowRow(
                modifier = Modifier.fillMaxWidth().widthIn(max = 1000.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalArrangement = Arrangement.spacedBy(40.dp)
            ) {
                // Column 1: Registered Office
                Column(
                    modifier = Modifier.widthIn(min = 280.dp, max = 350.dp),
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
                        text = "7-14(1)-9, AST 1085003765,\n2nd Floor, New Colony, Srikakulam II Town,\nSrikakulam, Srikakulam - 532001, Andhra Pradesh",
                        fontSize = 13.sp,
                        color = AppColors.TextSecondary,
                        lineHeight = 22.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

                // Column 2: Principal Place of Business
                Column(
                    modifier = Modifier.widthIn(min = 280.dp, max = 350.dp),
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
                        text = "Shop No.7A, D.No. 28-10-4, Third Floor,\nVasavi Plaza, Theatre Road, Revenue Ward No.27,\nJagadamba Jn, Visakhapatnam - 530020, Andhra Pradesh",
                        fontSize = 13.sp,
                        color = AppColors.TextSecondary,
                        lineHeight = 22.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            // Contact Bar (Pills)
            @OptIn(androidx.compose.foundation.layout.ExperimentalLayoutApi::class)
            FlowRow(
                modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
                horizontalArrangement = Arrangement.Center,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                ContactPill(text = "+91 93483 43310 | +91 79895 36155")
                ContactPill(text = "skillifestyle.vizag@gmail.com")
                ContactPill(text = "www.skillifestyle.in")
            }

            // Tagline wrapper
            Row(
                modifier = Modifier.fillMaxWidth().widthIn(max = 600.dp).padding(top = 24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Box(modifier = Modifier.weight(1f).height(1.dp).background(AppColors.BorderLight))
                Text(
                    text = "STEP INTO EXCELLENCE",
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    color = AppColors.TextPrimary,
                    letterSpacing = 2.sp,
                    modifier = Modifier.padding(horizontal = 24.dp)
                )
                Box(modifier = Modifier.weight(1f).height(1.dp).background(AppColors.BorderLight))
            }
        }
    }
}

@Composable
fun ContactPill(text: String) {
    Box(
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .background(Color.White, shape = RoundedCornerShape(999.dp))
            .border(width = 1.dp, color = AppColors.BorderLight, shape = RoundedCornerShape(999.dp))
            .padding(horizontal = 20.dp, vertical = 12.dp)
    ) {
        Text(
            text = text,
            color = AppColors.TextSecondary,
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}
