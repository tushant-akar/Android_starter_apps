package com.example.courses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.courses.data.DataSource
import com.example.courses.model.Topic
import com.example.courses.ui.theme.CoursesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoursesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CourseApp()
                }
            }
        }
    }
}

@Composable
fun CourseApp() {
    CoursesTheme {
        CourseList(courseList = DataSource().loadCourses())
    }
}

@Composable
fun CourseList(courseList: List<Topic>, modifier: Modifier = Modifier) {
    LazyColumn {
        items(courseList) { course ->
            CourseCard(course)
        }
    }
}

@Composable
fun CourseCard(course: Topic, modifier: Modifier = Modifier) {
    Card(modifier = Modifier.padding(8.dp)) {
        Row {
            Image(
                painter = painterResource(id = course.imageResourceId),
                contentDescription = null,
                modifier = Modifier
                    .height(68.dp)
                    .width(68.dp),
            contentScale = ContentScale.Crop)
            Column {
                Text(
                    text = LocalContext.current.getString(course.stringResourceId_name),
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .padding(horizontal = 16.dp),
                    style = MaterialTheme.typography.bodyMedium)
                Text(
                    text = LocalContext.current.getString(course.stringResourceId_courses),
                    modifier = Modifier.padding(top=8.dp),
                    textAlign = TextAlign.Center)
                
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CourseCard(Topic(R.string.architecture, 58, R.drawable.architecture))
}