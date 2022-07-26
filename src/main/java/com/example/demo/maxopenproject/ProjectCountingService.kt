package com.example.demo.maxopenproject


/**
 * Created by abdulbasit on 26/07/2022.
 */
class ProjectCountingService {
    /**
     * The count of open projects must always be >= 0.
     */
    private var myOpenProjectCount = 0
    fun incrProjectCount() {
        validateProjectCount()
        myOpenProjectCount++
    }

    fun decrProjectCount() {
        myOpenProjectCount--
        validateProjectCount()
    }

    fun projectLimitExceeded(): Boolean {
        return myOpenProjectCount > MAX_OPEN_PRJ_LIMIT
    }

    fun getProjectCount(): Int {
        return myOpenProjectCount
    }

    /**
     * Anti-bugging to ensure the count of open projects never goes below zero.
     */
    private fun validateProjectCount() {
        myOpenProjectCount = Math.max(myOpenProjectCount, 0)
    }

    companion object {
        /**
         * Sets the maximum allowed number of opened projects.
         */
        private const val MAX_OPEN_PRJ_LIMIT = 3
    }
}
