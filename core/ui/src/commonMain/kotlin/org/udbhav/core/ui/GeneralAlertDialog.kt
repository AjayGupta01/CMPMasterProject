package org.udbhav.core.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun GeneralAlertDialog(
    titleRes: StringResource,
    descriptionRes: StringResource?,
    confirmButtonTitleRes: StringResource,
    cancelButtonTitleRes: StringResource,
    onCancel: () -> Unit,
    onConfirm: () -> Unit
) {

    AlertDialog(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        onDismissRequest = onCancel,
        containerColor = Color(0xFF1C1C1E),
        title = {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = stringResource(titleRes),
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(12.dp))
                if (descriptionRes != null) {
                    Text(
                        text = stringResource(descriptionRes),
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        },
        confirmButton = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                AlertActionButton(
                    text = stringResource(cancelButtonTitleRes),
                    onClick = onCancel,
                    textColor = Color.White
                )
                Spacer(Modifier.width(12.dp))
                AlertActionButton(
                    text = stringResource(confirmButtonTitleRes),
                    onClick = onConfirm,
                    textColor = Color(0xFF1F1F1F),
                    backgroundColor = Color.White,
                    borderEnabled = false
                )
            }
        }

    )
}


@Composable
fun AlertActionButton(
    text: String,
    onClick: () -> Unit,
    textColor: Color,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = RoundedCornerShape(8.dp),
    backgroundColor: Color = Color.Transparent,
    borderEnabled: Boolean = true,
    fontWeight: FontWeight = FontWeight.Bold
) {
    OutlinedButton(
        onClick = onClick,
        shape = shape,
        border = ButtonDefaults.outlinedButtonBorder(borderEnabled),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = backgroundColor,
            contentColor = textColor
        ),
        enabled = enabled,
        modifier = modifier
    ) {
        Text(text, color = textColor, fontWeight = fontWeight)
    }
}