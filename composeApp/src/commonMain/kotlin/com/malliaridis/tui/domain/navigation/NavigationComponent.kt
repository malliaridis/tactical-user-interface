package com.malliaridis.tui.domain.navigation

/**
 * The navigation component is responsible for handling navigation inside the app. Navigation cases where this component
 * may be used are tab selections and back navigation.
 *
 * This component may be used in addition to other component implementations to add navigation handling. This may be
 * helpful if a component wants to manage depth, like opening and closing sub menus.
 *
 * It is up to the component's implementation if back navigation is supported and has any effect.
 */
interface NavigationComponent<T> {

    /**
     * Function that is called for navigating to a specific navigation element.
     *
     * @param element The navigation element to navigate to.
     */
    fun onNavigateTo(element: T)

    /**
     * Function for handling back navigation.
     */
    fun onNavigateBack()
}
