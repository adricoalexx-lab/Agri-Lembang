package com.projects.agrilembang.ui.Components.fab

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MultiFloatingActionButton(
    modifier: Modifier = Modifier,
    items: List<MultiFabItem>,
    fabState: MutableState<MultiFabState> = rememberMultiFabState(),
    fabIcon: FabIcon,
    fabOption: FabOption = fabOption(),
    onFabItemClicked: (fabItem: MultiFabItem) -> Unit,
    stateChanged: (fabState: MultiFabState) -> Unit = {}
) {
    val currentIcon = if(fabState.value.isExpanded()){
        fabIcon.expandIconRes
    } else {
        fabIcon.collapseIconRes
    }

    Column(
        modifier = modifier.wrapContentSize(),
        horizontalAlignment = Alignment.End
    ){
        AnimatedVisibility(
            visible = fabState.value.isExpanded(),
            enter = fadeIn() + expandVertically(),
            exit = fadeOut()
        ) {
            LazyColumn(
                modifier = Modifier.wrapContentSize(),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ){
                items(items.size){ index ->
                    MiniFabItem(
                        item = items[index],
                        fabOption = fabOption,
                        onFabItemClicked = onFabItemClicked
                    )
                }
                item {  }
            }
        }
        FloatingActionButton(
            onClick = {
            fabState.value = fabState.value.toggleValue()
            stateChanged(fabState.value)
        },
            contentColor = fabOption.iconTint,
            containerColor = fabOption.backgroundTint
        ) {
            Icon(
                painter = painterResource(id = currentIcon),
                contentDescription = "FAB",
                tint = fabOption.iconTint
            )
        }
    }
}

@Composable
fun MiniFabItem(
    item : MultiFabItem,
    fabOption: FabOption,
    onFabItemClicked: (item: MultiFabItem) -> Unit
){
    Row(
        modifier = Modifier
            .wrapContentSize()
            .padding(end = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        if (fabOption.showLabel){
            Text(
                text = item.label,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(horizontal = 6.dp, vertical = 4.dp)
            )
        }
        FloatingActionButton(
            onClick = {
                onFabItemClicked(item)
            },
            modifier = Modifier
                .size(40.dp),
            containerColor = fabOption.backgroundTint,
            contentColor = fabOption.iconTint
        ) {
            Icon(
                painter = painterResource(id = item.iconRes),
                contentDescription = "Float Icon",
                tint = fabOption.iconTint,
                modifier = Modifier
                    .size(25.dp)
            )
        }
    }
}