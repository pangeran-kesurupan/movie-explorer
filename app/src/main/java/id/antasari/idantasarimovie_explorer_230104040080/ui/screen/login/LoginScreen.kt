package id.antasari.idantasarimovie_explorer_230104040080.ui.screen.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import id.antasari.idantasarimovie_explorer_230104040080.ui.components.AppTextField
import id.antasari.idantasarimovie_explorer_230104040080.ui.components.PrimaryButton

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit
) {
    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Movie & TV Explorer",
            style = MaterialTheme.typography.displayMedium,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Discover movies and shows you love.",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(24.dp))

        AppTextField(
            value = emailState.value,
            onValueChange = { emailState.value = it },
            label = "Email",
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(12.dp))
        AppTextField(
            value = passwordState.value,
            onValueChange = { passwordState.value = it },
            label = "Password",
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))

        PrimaryButton(
            text = "Sign In",
            modifier = Modifier.fillMaxWidth(),
            onClick = { onLoginSuccess() }
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Continue as guest",
            style = MaterialTheme.typography.labelLarge
        )
    }
}