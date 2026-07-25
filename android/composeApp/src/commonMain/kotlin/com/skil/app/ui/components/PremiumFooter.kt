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
import com.skil.app.theme.MemphisColors

@Composable
fun PremiumFooter(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 40.dp, bottom = 20.dp)
            .background(Color.White)
            .border(width = 2.dp, color = Color.Black)
    ) {
        // Gold Accent Line
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(4.dp)
                .background(MemphisColors.LuxuryGold)
        )

        Column(
            modifier = Modifier.padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            // Address Section
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Registered Office
                Column(modifier = Modifier.weight(1f)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(6.dp)
                                .background(MemphisColors.LuxuryGold)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "REGISTERED OFFICE",
                            fontWeight = FontWeight.Black,
                            fontSize = 10.sp,
                            color = Color.Black,
                            letterSpacing = 1.sp
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "7-14(1)-9, AST 1085003765,\n2nd Floor, New Colony, Srikakulam II Town,\nSrikakulam, Srikakulam - 532001, Andhra Pradesh",
                        fontSize = 9.sp,
                        color = MemphisColors.TextMuted,
                        lineHeight = 14.sp
                    )
                }

                // Principal Place of Business
                Column(modifier = Modifier.weight(1f)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(6.dp)
                                .background(MemphisColors.LuxuryGold)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "PRINCIPAL PLACE OF BUSINESS",
                            fontWeight = FontWeight.Black,
                            fontSize = 10.sp,
                            color = Color.Black,
                            letterSpacing = 1.sp
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Shop No.7A, D.No. 28-10-4, Third Floor,\nVasavi Plaza, Theatre Road, Revenue Ward No.27,\nJagadamba Jn, Visakhapatnam - 530020, AP",
                        fontSize = 9.sp,
                        color = MemphisColors.TextMuted,
                        lineHeight = 14.sp
                    )
                }
            }

            // Divider
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Color.LightGray)
            )

            // Contact Info
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "+91 93483 43310 | +91 79895 36155",
                    fontSize = 9.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    text = "skillifestyle.vizag@gmail.com",
                    fontSize = 9.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    text = "www.skillifestyle.in",
                    fontSize = 9.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
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
                        .height(2.dp)
                        .background(MemphisColors.LuxuryGold)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "STEP INTO EXCELLENCE",
                    fontWeight = FontWeight.Black,
                    fontSize = 12.sp,
                    color = Color.Black,
                    letterSpacing = 2.sp
                )
                Spacer(modifier = Modifier.width(16.dp))
                Box(
                    modifier = Modifier
                        .width(40.dp)
                        .height(2.dp)
                        .background(MemphisColors.LuxuryGold)
                )
            }
        }
    }
}
