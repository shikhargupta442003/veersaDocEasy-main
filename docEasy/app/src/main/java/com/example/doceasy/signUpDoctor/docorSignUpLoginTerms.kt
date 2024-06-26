package com.example.doceasy.signUpDoctor

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.doceasy.R
import com.google.firebase.auth.FirebaseAuth

@Composable
fun docSignUpLoginTerms(navController: NavController,auth: FirebaseAuth){
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    val context= LocalContext.current


    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth()
    ) {
        Box(modifier = Modifier.padding(horizontal = 20.dp, vertical = 24.dp)) {
            Text(
                "SignUp Details",
                color = colorResource(id = R.color.theme_color1),
                fontSize = 24.sp,
                fontWeight = FontWeight.ExtraBold
            )
        }
        Text(
            text = "Email",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .background(color = colorResource(id = R.color.box_inside_color))
        ) {
            OutlinedTextField(
                value = email,
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .background(color = colorResource(id = R.color.box_inside_color))
                    .fillMaxWidth(),
                placeholder = {
                    Text(
                        "Enter Your Email",
                        color = colorResource(id = R.color.box_hint_color),
                        fontWeight = FontWeight.Bold
                    )
                },
                onValueChange = {
                    email=it
                }
            )
        }
        Spacer(modifier = Modifier.padding(vertical = 4.dp))
        Text(
            text = "Password",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .background(color = colorResource(id = R.color.box_inside_color))
        ) {
            OutlinedTextField(
                value = password,
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .background(color = colorResource(id = R.color.box_inside_color))
                    .fillMaxWidth(),
                placeholder = {
                    Text(
                        "Enter Password",
                        color = colorResource(id = R.color.box_hint_color),
                        fontWeight = FontWeight.Bold
                    )
                },
                onValueChange = {
                    password=it
                }
            )
        }
        Spacer(modifier = Modifier.padding(vertical = 4.dp))
        Text(
            text = "Terms and Conditions",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(bottom = 8.dp)
        )


        Spacer(modifier = Modifier.padding(vertical = 4.dp))

        Button(
            onClick = {

                if (email.isNotEmpty() && password.isNotEmpty()) {
                    signInWithEmailAndPassword(email, password,auth,context)
                } else {
                    Toast.makeText(context, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                }
                navController.navigate("docSignUp/$email")

            },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .size(52.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.theme_color1))
        ) {
            Text(text = "Next", fontWeight = FontWeight.ExtraBold, fontSize = 20.sp)
        }

    }
}
 fun signInWithEmailAndPassword(email: String, password: String,auth: FirebaseAuth,context: Context) {
    auth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener() { task ->
            if (task.isSuccessful) {
                Toast.makeText(context, "Authentication SuccessFull.", Toast.LENGTH_SHORT).show()
                // Sign in success, update UI with the signed-in user's information
            } else {
                // If sign in fails, display a message to the user.
                Toast.makeText(context, "Authentication failed.", Toast.LENGTH_SHORT).show()

            }
        }
}
