package com.example.goodsapp.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.goodsapp.domain.Product

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ProductItem(product: Product) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(182.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.Start
        ) {
            GlideImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .clip(
                        RoundedCornerShape(8.dp)
                    ),
                model = product.thumbnail,
                contentDescription = product.title,
                contentScale = ContentScale.FillBounds
            )
            Column(
                modifier = Modifier.padding(4.dp)
            ) {
                Text(
                    text = product.title,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 12.sp
                )
                Text(
                    text = product.description,
                    fontSize = 8.sp,
                    lineHeight = 8.sp
                )
            }
        }
    }
}
