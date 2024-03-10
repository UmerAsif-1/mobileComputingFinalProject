package com.example.hw3mc

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.google.android.gms.maps.model.LatLng
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.model.CameraPosition
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState


@Composable
fun MapScreen(navController: NavController) {
    val oulu = LatLng(65.0121, 25.4651)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(oulu, 15f)
    }
    Column() {


        Row(modifier = Modifier.padding(all = 8.dp)) {

            val navigateToFrontScreen: () -> Unit = {
                navController.navigate(route = Screen.FrontScreen.route) {
                    popUpTo(Screen.FrontScreen.route) {
                        inclusive = true
                    }
                }
            }

            Button(onClick = navigateToFrontScreen) {
                Text("Back")
            }
    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    ) {
        Marker(
            state = MarkerState(position = oulu),
            title = "Oulu",
            snippet = "This is Oulu"
        )
    }
}}}